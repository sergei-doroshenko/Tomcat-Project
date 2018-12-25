package org.sdoroshenko;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Sergei_Doroshenko on 1/24/2017.
 */
public class MessageServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(MessageServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        this.process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        this.process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(200);
        try {
            String name = request.getParameter("name");
            logger.info("Sending message for: " + name);
            response.getWriter().write(
                new Reporter().report(request.getMethod() + ": hello: " + name).print()
            );
        } catch (IOException e) {
            logger.warning(e.getMessage());
        }
    }

}
