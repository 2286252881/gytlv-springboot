<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Random"%>
<%@ page import="java.io.OutputStream"%>
<%@ page import="java.awt.Color"%>
<%@ page import="java.awt.Font"%>
<%@ page import="java.awt.Graphics"%>
<%@ page import="java.awt.image.BufferedImage"%>
<%@ page import="javax.imageio.ImageIO"%>
<%! 
	Color getRandColor(int fc,int bc) 
	{ 
		Random random = new Random(); 
		if(fc>255) fc=255; 
		if(bc>255) bc=255; 
		int r=fc+random.nextInt(bc-fc); 
		int g=fc+random.nextInt(bc-fc); 
		int b=fc+random.nextInt(bc-fc); 
		return new Color(r,g,b); 
	} 
%> 
<%
	int width =75;
	int height = 32;
	//create the image
	BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	Graphics g = image.getGraphics();
	// set the background color
	g.setColor(getRandColor(200,250));
	g.fillRect(0, 0, width, height);
	// draw the border
	g.setColor(getRandColor(130,250));
	g.drawRect(0, 0, width - 1, height - 1);
	// create a random instance to generate the codes
	Random rdm = new Random();
	String hash1 = Integer.toHexString(rdm.nextInt());
	System.out.print(hash1);
	// make some confusion
	for (int i = 0; i < 50; i++) {
		int x = rdm.nextInt(width);
		int y = rdm.nextInt(height);
		g.drawOval(x, y, 0, 0);
	}
	// generate a random code
	String capstr = hash1.substring(0, 4);
	//将生成的验证码存入session
	session.setAttribute("validateCode", capstr);
	g.setColor(getRandColor(150,200));
	g.setFont(new Font("Algerian", Font.PLAIN, 24));
	g.drawString(capstr, 8, 24);
	g.dispose();
	//输出图片
	response.setContentType("image/jpeg");
	out.clear();
	out = pageContext.pushBody();
	OutputStream strm = response.getOutputStream();
	ImageIO.write(image, "jpeg", strm);
	strm.close();
%>