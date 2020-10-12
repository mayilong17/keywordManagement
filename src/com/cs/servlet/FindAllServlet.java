package com.cs.servlet;

import com.cs.entity.KeyWord;
import com.cs.service.KeyWordService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet("/findAllServlet")
public class FindAllServlet extends HttpServlet {
    private KeyWordService keyWordService=new KeyWordService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String comm = request.getParameter("comm");
        if ("list".equals(comm)){
            List<KeyWord> list = keyWordService.findAllService();
            request.setAttribute("list",list);
            request.getRequestDispatcher("/findall.jsp").forward(request,response);
        }
        if ("del".equals(comm)){
            String id = request.getParameter("id");
            boolean b = keyWordService.deleteService(Integer.parseInt(id));
            if (b){
                request.getRequestDispatcher("/index.jsp").forward(request,response);
            }else{
                System.out.println("删除失败！");
            }
        }
        if ("add".equals(comm)){
            String name = request.getParameter("name");
            String type = request.getParameter("type");
            String date = request.getParameter("date");
            KeyWord keyWord = new KeyWord();
            keyWord.setName(name);
            keyWord.setType(type);
            try {
                keyWord.setCreateDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            boolean b = keyWordService.addService(keyWord);
            if (b){
                response.sendRedirect("/keywordManagement/index.jsp");
            }else {
                System.out.println("添加失败！");
            }
        }
        if ("nn".equals(comm)){
            Map<String,Object> map=new HashMap();
            String name = request.getParameter("keyname");
            KeyWord keyWord = keyWordService.queryService(name);
            if (keyWord!=null){
                map.put("keyExsit",true);
                map.put("msg","关键词名重复，请换一个！");
            }else{
                map.put("keyExsit",false);
                map.put("msg","关键词可用！");
            }
            ObjectMapper Mapper = new ObjectMapper();
            Mapper.writeValue(response.getWriter(),map);

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
