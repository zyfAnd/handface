package com.soyeah;

import com.google.gson.Gson;
import com.soyeah.model.KeyWord;
import com.soyeah.model.TemplateMsg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HandfaceApplicationTests {

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

}
