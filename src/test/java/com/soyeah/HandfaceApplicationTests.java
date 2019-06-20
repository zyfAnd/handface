package com.soyeah;

import com.google.gson.Gson;
import com.soyeah.mapper.UserMapper;
import com.soyeah.model.KeyWord;
import com.soyeah.model.TemplateMsg;
import com.soyeah.model.entity.User;
import com.soyeah.util.SharedImageUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HandfaceApplicationTests {


	@Autowired
	UserMapper userMapper;
	@Test
	public void contextLoads() {
		Gson gson = new Gson();
		TemplateMsg  templateMsg =  new TemplateMsg();

		Map map =  new HashMap();
		KeyWord keyWord1 = new KeyWord();
		keyWord1.setColor("#173177");
		keyWord1.setValue("339208499");
		map.put("keyword1",keyWord1);

		KeyWord keyWord2 = new KeyWord();
		keyWord2.setColor("#173177");
		keyWord2.setValue("339208499");
		map.put("keyword2",keyWord2);

		templateMsg.setTouser("OPENID");
		templateMsg.setForm_id("TEMPLATE_ID");
		templateMsg.setPage("index");
		templateMsg.setTemplate_id("TEMPLATE_ID");


		templateMsg.setData(map);
		String json  = gson.toJson(templateMsg);
		System.out.print(json);
	}
	@Test
	public void testShareImgaesUtils() throws Exception{
		// 头像

		String avastar = "/Users/yanfu/IdeaProjects/handface-master/src/main/resources/share.jpg";
		// 二维码
		String qrcode = "/Users/yanfu/IdeaProjects/handface-master/src/main/resources/qrcode.jpg";
		// 二维码识别图
		String point = "/Users/yanfu/IdeaProjects/handface-master/src/main/resources/point.png";
		// 背景图片
		String background = "/Users/yanfu/IdeaProjects/handface-master/src/main/resources/background.jpg";

		// 1. 通过背景图片构建 BufferedImage
		BufferedImage zoomPicture = ImageIO.read(new File(background));
		// 2. 头像裁剪成圆形
		BufferedImage roundedImage = SharedImageUtils.createRoundedImage(avastar, SharedImageUtils.AVATAR_SIZE);
		// 3. 合并头像，昵称
		BufferedImage mergeImage = SharedImageUtils.mergePicture(zoomPicture, roundedImage, "扶摇");
		// 4. 合并二维码及二维码识别图
//		mergeImage = SharedImageUtils.mergeQrcode(mergeImage, qrcode, background);

		BufferedImage mergeImageRes_01 = SharedImageUtils.drawTextInImage(mergeImage,"官阶",500,250);
		BufferedImage mergeImageRes_02 = SharedImageUtils.drawTextInImage(mergeImageRes_01,"一品",500,320);
		BufferedImage mergeImageRes_03 = SharedImageUtils.drawTextInImage(mergeImageRes_02,"房室",550,250);
		BufferedImage mergeImageRes_04 = SharedImageUtils.drawTextInImage(mergeImageRes_03,"三妻四妾",550,320);

		BufferedImage mergeImageRes_05 = SharedImageUtils.drawTextInImage(mergeImageRes_04,"幸福指数",600,250);
		BufferedImage mergeImageRes_06 = SharedImageUtils.drawTextInImage(mergeImageRes_05,"88.9",600,360);
		BufferedImage mergeImageRes_07 = SharedImageUtils.drawTextInImage(mergeImageRes_06,"年薪",500,450);
		BufferedImage mergeImageRes_08 = SharedImageUtils.drawTextInImage(mergeImageRes_07,"500两",500,520);
		BufferedImage mergeImageRes_09 = SharedImageUtils.drawTextInImage(mergeImageRes_08,"享年",550,450);
		BufferedImage mergeImageRes_10 = SharedImageUtils.drawTextInImage(mergeImageRes_09,"99",550,520);
		BufferedImage mergeImageRes_11 = SharedImageUtils.drawTextInImage(mergeImageRes_10,"击败",600,450);
		BufferedImage mergeImageRes_12 = SharedImageUtils.drawTextInImage(mergeImageRes_11,"98%",600,520);

		// 5. 生成分享图
		ImageIO.write(mergeImageRes_12, "jpg", new File("/Users/yanfu/IdeaProjects/handface-master/src/main/resources/testRes.jpg"));
	}

	@Test
	public void testSaveUser(){

//
//		User user = new User(1,"12212","xiaoer",
//				"www.com",2,
//				"shanghai","China","Shanghai",1,"12212x");

		User user = new User();
		user.setUsername("haha");
		user.setOpenid("1ss");
		user.setPoint(1);
		user.setCity("citi");
		user.setForm_id("xx11");
		user.setCountry("China");
		user.setProvince("Shanghai");
		user.setGender(1);
		user.setImageUrl("www");


		userMapper.saveUser(user);


	}

}
