package com.toukubo.pomodoro.web;


import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.arnx.jsonic.JSON;

import com.toukubo.pomodoro.Pomodoro;

/**
 * Servlet implementation class SearchNotesServlet
 */
@WebServlet("/GetPomodoro")
public class GetPomodoro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
        	response.setHeader("Access-Control-Allow-Origin", "*");
//        	String query = "reminderOrder:* -reminderTime:day+1 -reminderDoneTime:day+1";
        	String id = request.getParameter("id");
        	Pomodoro pomodoro = new Pomodoro();
        	Pomodoro found = (Pomodoro)pomodoro.find(Long.valueOf(id));
    		Map<String, Object> map = new HashMap<String,Object>();

            map.put("pomodoro", found);

    		//json
    		OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream(), "UTF-8");
    		JSON.encode(map,writer);
    		writer.flush();
    		writer.close();
        	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
