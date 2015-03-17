package com.toukubo.pomodoro.web;


import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.arnx.jsonic.JSON;

import com.toukubo.projects.Project;

/**
 * Servlet implementation class SearchNotesServlet
 */
@WebServlet("/Projects")
public class Projects extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
        	response.setHeader("Access-Control-Allow-Origin", "*");
        	
        	
        	Project project = new Project();
//        	String id = request.getParameter("id");
//        	Project found = (Project)project.find(Long.valueOf(id));
        	List projects = (List)project.list();
    		Map<String, Object> map = new HashMap<String,Object>();

            map.put("projects", projects);

            
            
            
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
