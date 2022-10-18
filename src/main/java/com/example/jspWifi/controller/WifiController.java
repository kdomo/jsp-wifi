package com.example.jspWifi.controller;

import com.example.jspWifi.domain.Wifi;
import com.example.jspWifi.domain.WifiHistory;
import com.example.jspWifi.service.WifiService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/wifi/*")
public class WifiController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String url = request.getRequestURI();
        String cmd = url.replace("/wifi", "");

        if (cmd.equals("/saveAll")) {
            WifiService wifiService = new WifiService();
            int saveCount = wifiService.saveAll();
            RequestDispatcher rd = request.getRequestDispatcher("/getComplete.jsp");
            request.setAttribute("saveCount", saveCount);
            rd.forward(request, response);
        } else if (cmd.equals("/saveHistory")) {
            WifiService wifiService = new WifiService();
            String x = request.getParameter("x");
            String y = request.getParameter("y");
            String rs = String.valueOf(wifiService.saveHistory(x, y));
            response.getWriter().write(rs);
        } else if (cmd.equals("/getInfo")) {
            WifiService wifiService = new WifiService();
            String x = request.getParameter("x");
            String y = request.getParameter("y");
            ArrayList<Wifi> list = wifiService.getInfo(x, y);
            Gson gson = new Gson();
            response.getWriter().write(gson.toJson(list));
        } else if (cmd.equals("/history")) {
            WifiService wifiService = new WifiService();
            ArrayList<WifiHistory> list = wifiService.getHistory();
            Gson gson = new Gson();
            response.getWriter().write(gson.toJson(list));
        } else if (cmd.equals("/deleteHistory")) {
            WifiService wifiService = new WifiService();
            String id = request.getParameter("id");
            String rs = String.valueOf(wifiService.deleteHistory(id));
            response.getWriter().write(rs);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
