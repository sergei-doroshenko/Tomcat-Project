package org.sergei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Sergei_Doroshenko on 1/24/2017.
 */
public class SimpleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

        URL localhost = new URL("http://localhost:9080/webapp01/simple");

        HttpURLConnection connection;
        connection = (HttpURLConnection) localhost.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        connection.setDoInput(true);

        /*OutputStream wr = connection.getOutputStream ();

        InputStream in = request.getInputStream();
        byte[] buffer = new byte[512];
        int read = in.read(buffer,0, buffer.length);
        while (read >= 0) {
            wr.write(buffer,0, read);
            read = in.read(buffer,0,buffer.length);
        }

        wr.flush ();
        wr.close ();*/

        StringBuffer sb = new StringBuffer();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            sb.append(inputLine);
        }

        response.setStatus(200);
        response.getWriter().write("webapp02");
        response.getWriter().write(sb.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

}
