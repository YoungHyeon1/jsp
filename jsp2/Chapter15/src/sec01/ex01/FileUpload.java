package sec01.ex01;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.MultipartConfig;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import jakarta.servlet.http.Part;

@WebServlet("/upload.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
maxFileSize = 1024 * 1024 * 5, 
maxRequestSize = 1024 * 1024 * 5 * 5)
public class FileUpload extends HttpServlet {
	
    private String getSubmittedFileName(Part part) {
        String header = part.getHeader("content-disposition");
        String[] elements = header.split(";");
        for (String element : elements) {
            if (element.trim().startsWith("filename")) {
                return element.substring(element.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String encoding = "utf-8";
		try {
			// 멀티파트 요청에서 파일 파트를 얻음
			Collection<Part> filePart = request.getParts();
			// 파일 이름 추출
			for (Part part : filePart) {
				String contentType = part.getContentType();
				System.out.println(contentType);
				if (contentType != null) {
					String fileName = getSubmittedFileName(part);
					String uploadDirectory = "/Users/gim-yeonghyeon/Documents/GitHub/jsp/file_updn/" + fileName;
					System.out.println("매개변수이름:" + part.getName());
					System.out.println("파일명: " + fileName);
					System.out.println("파일크기: " + part.getSize());

					try (InputStream fileContent = part.getInputStream()) {
						Files.copy(fileContent, Paths.get(uploadDirectory), StandardCopyOption.REPLACE_EXISTING);
					}
				} else {
					System.out.println(part.getName());
				}

			}
			response.getWriter().write("File upload completed");
		} catch (Exception e) {
			// 예외 처리
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.getWriter().write("File upload failed");
		}
	}

}

