package com.app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.*;

public class DataProcessServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		// Get user text from html form to String named "usertext"
		String usertext = req.getParameter("user_text");
		
		// Generating a writer object
		PrintWriter out = res.getWriter();
		
		// Creating and calling the NLPProcessing class object to do processing and saving output to String
		NLPProcessing np = new NLPProcessing();
		String output = np.process(usertext);
		
		System.out.println(output);
		
		// Displaying output on page
		out.println(" THE USER INPUT IS: \n" + usertext + " \n\n\nTHE GRAMMAR RESULTS ARE: \n " + output);
			
	}
}

