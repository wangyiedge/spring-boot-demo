package cn.me.edge.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletResponse;
import java.io.PrintWriter;

/**
 * 返回结果工具类
 *
 * @author edge
 */
@Slf4j
public class ResponseUtil {

    /**
     * 使用response输出JSON
     *
     * @author edge
     */
    public static void responseJson(ServletResponse response, Object object) {
        PrintWriter out = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            out = response.getWriter();
            out.println(objectMapper.writeValueAsString(object));
        } catch (Exception e) {
            log.error("format json error！msg: " + e);
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }
}