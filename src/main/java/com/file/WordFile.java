package com.file;

import java.io.*;

import com.itextpdf.text.*;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.signup.*;

import jakarta.servlet.http.*;
public class WordFile extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException 
	{
		GeneratePdf pdf = new GeneratePdf();
		PrintWriter out = res.getWriter();
		out.println("IN WordFile");
		
	}
}