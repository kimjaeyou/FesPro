package wep.mvc.listener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.SQLException;
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
import wep.mvc.dto.FesDTO;
import wep.mvc.dto.ListPublicReservationCulture;
import wep.mvc.dto.RESULT;
import wep.mvc.dto.row;
import wep.mvc.service.FesSerevice;
import wep.mvc.service.FesSereviceImpl;

@WebListener
public class HandleMappingListner implements ServletContextListener {
	static String str1;
	static String str2;

	@Override
	public void contextInitialized(ServletContextEvent e) {
		try {
			Test(e);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Map<String, Controller> map = new HashMap<String, Controller>();
		Map<String, Class<?>> classMap = new HashMap<String, Class<?>>();

		ResourceBundle rb = ResourceBundle.getBundle("actionMappings");

		try {
			for (String key : rb.keySet()) {
				String value = rb.getString(key);

				Class<?> className = Class.forName(value);
				Controller con = (Controller) className.getDeclaredConstructor().newInstance();

				classMap.put(key, className);
				map.put(key, con);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		ServletContext app = e.getServletContext();
		System.out.println("map = " + map);
		System.out.println("classMap = "+classMap);
		app.setAttribute("classMap", classMap);
		app.setAttribute("map", map);
		app.setAttribute("path", app.getContextPath());
	}

	public static void Test(ServletContextEvent e) throws IOException {
		StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088");
		urlBuilder.append("/" + URLEncoder.encode("6d556870756c736d36336f756f456d", "UTF-8"));
		urlBuilder.append("/" + URLEncoder.encode("json", "UTF-8"));
		urlBuilder.append("/" + URLEncoder.encode("ListPublicReservationCulture", "UTF-8"));
		urlBuilder.append("/" + URLEncoder.encode("1", "UTF-8"));
		urlBuilder.append("/" + URLEncoder.encode("50", "UTF-8"));

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

							str1 = rowObject.optString("AREANM", "");
							if (str1.equals("종로구")) {
								rowItem.sethost_seq(50);
							} else if (str1.equals("중구")) {
								rowItem.sethost_seq(51);
							} else if (str1.equals("성동구")) {
								rowItem.sethost_seq(52);
							} else if (str1.equals("마포구")) {
								rowItem.sethost_seq(53);
							} else if (str1.equals("영등포구")) {
								rowItem.sethost_seq(54);
							} else if (str1.equals("과천시")) {
								rowItem.sethost_seq(55);
							} else if (str1.equals("동작구")) {
								rowItem.sethost_seq(56);
							} else if (str1.equals("성북구")) {
								rowItem.sethost_seq(57);
							} else if (str1.equals("용산구")) {
								rowItem.sethost_seq(58);
							} else if (str1.equals("")) {
								rowItem.sethost_seq(59);
							} else if (str1.equals("강북구")) {
								rowItem.sethost_seq(60);
							} else if (str1.equals("강동구")) {
								rowItem.sethost_seq(61);
							} else if (str1.equals("동대문구")) {
								rowItem.sethost_seq(62);
							} else if (str1.equals("양천구")) {
								rowItem.sethost_seq(63);
							} else if (str1.equals("관악구")) {
								rowItem.sethost_seq(64);
							} else if (str1.equals("중랑구")) {
								rowItem.sethost_seq(65);
							} else if (str1.equals("금천구")) {
								rowItem.sethost_seq(66);
							} else if (str1.equals("강서구")) {
								rowItem.sethost_seq(67);
							} else if (str1.equals("노원구")) {
								rowItem.sethost_seq(68);
							} else if (str1.equals("도봉구")) {
								rowItem.sethost_seq(69);
							} else if (str1.equals("은평구")) {
								rowItem.sethost_seq(70);
							} else if (str1.equals("서대문구")) {
								rowItem.sethost_seq(71);
							} else if (str1.equals("광진구")) {
								rowItem.sethost_seq(72);
							} else if (str1.equals("구로구")) {
								rowItem.sethost_seq(73);
							} else if (str1.equals("강남구")) {
								rowItem.sethost_seq(74);
							} else if (str1.equals("송파구")) {
								rowItem.sethost_seq(75);
							} else {
								rowItem.sethost_seq(76);
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

				// System.out.println(dto.getRow());
				ServletContext app = e.getServletContext();

				// app.setAttribute("fesList", dto);//행사 데이터 application영역에 저장
				Test2(e, dto.getRow());
			} else {
				System.out.println("ListPublicReservationCulture 데이터가 없습니다.");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("JSON 데이터 파싱 중 오류가 발생했습니다.");
		}
	}

	public static void Test2(ServletContextEvent e, List<row> rowList) {
		List<FesDTO> fesDTOList = new ArrayList<FesDTO>();
		for (row row1 : rowList) {
			fesDTOList.add(new FesDTO(row1.getSVCID(), row1.getMAXCLASSNM(), row1.getMINCLASSNM(), row1.getSVCSTATNM(),
					row1.getSVCNM(), row1.getPAYATNM(), row1.getPLACENM(), row1.getUSETGTINFO(), row1.getX(),
					row1.getY(), row1.getSVCOPNBGNDT(), row1.getSVCOPNENDDT(), row1.getRCPTBGNDT(), row1.getAREANM(),
					row1.getIMGURL(), row1.getDTLCONT(), row1.getTELNO(), row1.getV_MAX(), row1.getV_MIN(),
					row1.getREVSTDDAY(), row1.getREVSTDDAYNM(), 1, "2024-10-15 00:00:00", 20, 0, row1.gethost_seq(),
					row1.getRCPTENDDT()));

		}

		////// 시작: fes db에 있는거 뽑아와서
		////// 넣어보아요//////////////////////////////////////////////////

		// 1. fesSerevice 생성, db에 있는거 읽어서 담는 List<FesDTO>, 최종 application에 담을 List<FesDTO> 생성
		FesSerevice fesSerevice = new FesSereviceImpl();
		List<FesDTO> fesDTOListfromDB = new ArrayList<FesDTO>();
		List<FesDTO> fin = new ArrayList<FesDTO>();
		
		// 2. fes db에 있는거 뽑아오기
		try {
			fesDTOListfromDB = fesSerevice.selectALL();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		// 3. 중복 비교
		for (FesDTO fdb : fesDTOListfromDB) { // db에서 꺼내온 것들
			boolean exist = false;
			for (FesDTO adb : fesDTOList) { // application에 넣을 것들
				if (fdb.getSVCID().equals(adb.getSVCID())) {
					exist= true;
					break;
				}
			}
			if(!exist && fdb.getFes_state()==1) {
				fin.add(fdb); //db에만 있고 app에 없는거 담아 근데 승인완료상태인 것만 담아
			}
		}	

		for (FesDTO adb : fesDTOList) {
			fin.add(adb);
		}

		////// 끝: fes db에 있는거 뽑아와서
		////// 넣어보아요//////////////////////////////////////////////////

		ServletContext app = e.getServletContext();
		app.setAttribute("fesList", fin);
	}// Test2 End

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		FesSerevice fesSerevice = new FesSereviceImpl();
		ServletContext app = sce.getServletContext();
		List<FesDTO> fesDTO = (List<FesDTO>) app.getAttribute("fesList");
		try {
			for (FesDTO fesdto : fesDTO) {
				// System.out.println("fesdto.host_Seq: "+fesdto.getHost_seq());
				if (fesSerevice.selectBySVCID(fesdto.getSVCID()) != null) {
					continue;
				} else {
					fesSerevice.insertListener(fesdto);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
