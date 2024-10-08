package wep.mvc.listener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import wep.mvc.controller.Controller;
import wep.mvc.dto.ListPublicReservationCulture;
import wep.mvc.dto.RESULT;
import wep.mvc.dto.row;

@WebListener
public class HandleMappingListner implements ServletContextListener {
	static String str1;
	static String str2;
	
	
	@Override
	public void contextInitialized(ServletContextEvent e) {
		try {
			Test();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Map<String,Controller>map=new HashMap<String, Controller>();
		Map<String,Class<?>>classMap=new HashMap<String, Class<?>>();
		
		ResourceBundle rb = ResourceBundle.getBundle("actionMappings");
		
		try {
			for (String key : rb.keySet()) {
				String value = rb.getString(key);
				
				Class<?>className= Class.forName(value);
				Controller con=(Controller)className.getDeclaredConstructor().newInstance();
				
				classMap.put(key, className);
				map.put(key, con);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		ServletContext app=e.getServletContext();
		System.out.println(map);
		System.out.println(classMap);
		app.setAttribute("classMap",classMap);
		app.setAttribute("map", map);
		app.setAttribute("path", app.getContextPath());
	}
	
	
	public static void Test() throws IOException {
	    StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088");
	    urlBuilder.append("/" + URLEncoder.encode("6d556870756c736d36336f756f456d", "UTF-8"));
	    urlBuilder.append("/" + URLEncoder.encode("json", "UTF-8"));
	    urlBuilder.append("/" + URLEncoder.encode("ListPublicReservationCulture", "UTF-8"));
	    urlBuilder.append("/" + URLEncoder.encode("1", "UTF-8"));
	    urlBuilder.append("/" + URLEncoder.encode("200", "UTF-8"));

	    URL url = new URL(urlBuilder.toString());
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setRequestMethod("GET");
	    conn.setRequestProperty("Content-type", "application/json");

	    BufferedReader rd;
	    if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	        rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    } else {
	        rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	    }

	    StringBuilder sb = new StringBuilder();
	    String line;
	    while ((line = rd.readLine()) != null) {
	        sb.append(line + "\n");
	    }
	    rd.close();
	    conn.disconnect();

	    // JSON 파싱
	    try {
	        JSONObject jsonObject = new JSONObject(new JSONTokener(sb.toString()));
	        JSONObject response = jsonObject.optJSONObject("ListPublicReservationCulture");

	        if (response != null) {
	            ListPublicReservationCulture dto = new ListPublicReservationCulture();
	            dto.setList_total_count(response.optInt("list_total_count", 0));

	            JSONObject resultObject = response.optJSONObject("RESULT");
	            if (resultObject != null) {
	                RESULT result = new RESULT();
	                result.setCODE(resultObject.optString("CODE", ""));
	                result.setMESSAGE(resultObject.optString("MESSAGE", ""));
	                dto.setRESULT(result);
	            }

	            JSONArray rows = response.optJSONArray("row");
	            if (rows != null) {
	                List<row> rowList = new ArrayList<>();
	                for (int i = 0; i < rows.length(); i++) {
	                    JSONObject rowObject = rows.optJSONObject(i);
	                    if (rowObject != null) {
	                        row rowItem = new row();
	                        rowItem.setGUBUN(rowObject.optString("GUBUN", ""));
	                        rowItem.setSVCID(rowObject.optString("SVCID", ""));
	                        rowItem.setMAXCLASSNM(rowObject.optString("MAXCLASSNM", ""));
	                        rowItem.setMINCLASSNM(rowObject.optString("MINCLASSNM", ""));
	                        rowItem.setSVCSTATNM(rowObject.optString("SVCSTATNM", ""));
	                        rowItem.setSVCNM(rowObject.optString("SVCNM", ""));
	                        rowItem.setPAYATNM(rowObject.optString("PAYATNM", ""));
	                        rowItem.setPLACENM(rowObject.optString("PLACENM", ""));
	                        
	                        str1=rowObject.optString("AREANM", "");
	                        if(str1.equals("종로구")) {
	                        	rowItem.sethost_seq(1);
	                        }else if(str1.equals("중구")) {
	                        	rowItem.sethost_seq(2);
	                        }else if(str1.equals("성동구")) {
	                        	rowItem.sethost_seq(3);
	                        }else if(str1.equals("마포구")) {
	                        	rowItem.sethost_seq(4);
	                        }else if(str1.equals("영등포구")) {
	                        	rowItem.sethost_seq(5);
	                        }else if(str1.equals("과천시")) {
	                        	rowItem.sethost_seq(6);
	                        }else if(str1.equals("동작구")) {
	                        	rowItem.sethost_seq(7);
	                        }else if(str1.equals("성북구")) {
	                        	rowItem.sethost_seq(8);
	                        }else if(str1.equals("용산구")) {
	                        	rowItem.sethost_seq(9);
	                        }else if(str1.equals("")) {
	                        	rowItem.sethost_seq(10);
	                        }else if(str1.equals("강북구")) {
	                        	rowItem.sethost_seq(11);
	                        }else if(str1.equals("강동구")) {
	                        	rowItem.sethost_seq(12);
	                        }else if(str1.equals("동대문구")) {
	                        	rowItem.sethost_seq(13);
	                        }else if(str1.equals("양천구")) {
	                        	rowItem.sethost_seq(14);
	                        }else if(str1.equals("관악구")) {
	                        	rowItem.sethost_seq(15);
	                        }else if(str1.equals("중랑구")) {
	                        	rowItem.sethost_seq(16);
	                        }else if(str1.equals("금천구")) {
	                        	rowItem.sethost_seq(17);
	                        }else if(str1.equals("강서구")) {
	                        	rowItem.sethost_seq(18);
	                        }else if(str1.equals("노원구")) {
	                        	rowItem.sethost_seq(19);
	                        }else if(str1.equals("도봉구")) {
	                        	rowItem.sethost_seq(20);
	                        }else if(str1.equals("은평구")) {
	                        	rowItem.sethost_seq(21);
	                        }else if(str1.equals("서대문구")) {
	                        	rowItem.sethost_seq(22);
	                        }else if(str1.equals("광진구")) {
	                        	rowItem.sethost_seq(23);
	                        }else if(str1.equals("구로구")) {
	                        	rowItem.sethost_seq(24);
	                        }else if(str1.equals("강남구")) {
	                        	rowItem.sethost_seq(25);
	                        }else if(str1.equals("송파구")) {
	                        	rowItem.sethost_seq(26);
	                        }else {
	                        	rowItem.sethost_seq(27);
	                        }

	                        rowItem.setUSETGTINFO(rowObject.optString("USETGTINFO", ""));
	                        rowItem.setSVCURL(rowObject.optString("SVCURL", ""));
	                        rowItem.setX(rowObject.optString("X", ""));
	                        rowItem.setY(rowObject.optString("Y", ""));
	                        rowItem.setSVCOPNBGNDT(rowObject.optString("SVCOPNBGNDT", ""));
	                        rowItem.setSVCOPNENDDT(rowObject.optString("SVCOPNENDDT", ""));
	                        rowItem.setRCPTBGNDT(rowObject.optString("RCPTBGNDT", ""));
	                        rowItem.setRCPTENDDT(rowObject.optString("RCPTENDDT", ""));
	                        rowItem.setAREANM(rowObject.optString("AREANM", ""));
	                        rowItem.setIMGURL(rowObject.optString("IMGURL", ""));
	                        rowItem.setDTLCONT(rowObject.optString("DTLCONT", ""));
	                        rowItem.setTELNO(rowObject.optString("TELNO", ""));
	                        rowItem.setV_MIN(rowObject.optString("V_MIN", ""));
	                        rowItem.setV_MAX(rowObject.optString("V_MAX", ""));
	                        rowItem.setREVSTDDAYNM(rowObject.optString("REVSTDDAYNM", ""));
	                        rowItem.setREVSTDDAY(rowObject.optString("REVSTDDAY", ""));
	                        rowList.add(rowItem);
	                    }
	                }
	                dto.setRow(rowList);
	               
	            }
	            
	            // dto에 파싱된 데이터가 들어간 상태
	            System.out.println(dto);
	            System.out.println(dto.getRow());
	            
	        } else {
	            System.out.println("ListPublicReservationCulture 데이터가 없습니다.");
	        }

	    } catch (Exception ex) {
	        ex.printStackTrace();
	        System.out.println("JSON 데이터 파싱 중 오류가 발생했습니다.");
	    }
	    
	}

	
}
