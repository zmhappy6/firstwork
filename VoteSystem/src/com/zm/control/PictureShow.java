package com.zm.control;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;

import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.zm.dao.VoteItemDao;
import com.zm.entity.VoteItem;
public class PictureShow extends MultiActionController{
	private VoteItemDao voteItemDao;
	private String filename;
	private String show;
	OutputStream out;
	public VoteItemDao getVoteItemDao() {
		return voteItemDao;
	}

	public void setVoteItemDao(VoteItemDao voteItemDao) {
		this.voteItemDao = voteItemDao;
	}

	public String getShow() {
		return show;
	}

	public void setShow(String show) {
		this.show = show;
	}

	public ModelAndView play(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		
	DefaultPieDataset defaultpiedataset = new DefaultPieDataset();  
	int vote_id=Integer.parseInt(request.getParameter("id"));
	List<VoteItem> list=voteItemDao.findAllItemByVoteId(vote_id);
	for(int i=0;i<list.size();i++){
		defaultpiedataset.setValue(list.get(i).getTitle(), list.get(i).getVotenum());
	}
	PiePlot3D plot=new PiePlot3D(defaultpiedataset);
	plot.setToolTipGenerator(new StandardPieToolTipGenerator());
	Font font=new Font("黑体", Font.CENTER_BASELINE, 20);
	JFreeChart chart=new JFreeChart("",JFreeChart.DEFAULT_TITLE_FONT,plot,true);
	TextTitle ttTextTitle=new TextTitle("结果比例图");
	ttTextTitle.setFont(font);
	chart.setBackgroundPaint(new java.awt.Color(0xF3,0xFA,0xFF));
	chart.setTitle(ttTextTitle);
	ChartRenderingInfo info=new ChartRenderingInfo(new StandardEntityCollection());
	try {
		filename=ServletUtilities.saveChartAsPNG(chart, 500, 300, info, session);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		 out = new FileOutputStream(filename);
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	PrintWriter pw=new PrintWriter(out);
	try {
		ChartUtilities.writeImageMap(pw, filename, info, true);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	pw.flush();
	String url=request.getContextPath()+"/DisplayChart?filename="+filename;
	request.setAttribute("url", url);
	return new ModelAndView(getShow());
	}
	 
}
