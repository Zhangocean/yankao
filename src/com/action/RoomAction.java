package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.RoomDAO;
import com.entity.Cate;
import com.entity.Room;

//定义为控制器
@Controller
//设置路径
@RequestMapping("/room")
public class RoomAction {
	private RoomDAO roomDAO;
	
	
	// 准备添加数据
	@RequestMapping("createRoom.action")
	public String createRoom(Map<String, Object> map) {
		return "admin/addroom";
	}

	// 添加数据
	@RequestMapping("addRoom.action")
	public String addRoom(Room room) {
		this.roomDAO.insertRoom(room);
		return "redirect:/room/getAllRoom.action";
	}
	// 更新教室
		@RequestMapping("updateRoom.action")
		public String updateRoom(Room room ) {
			this.roomDAO.updateRoom(room);
			return "redirect:/room/getAllRoom.action";
		}
		
		// 按主键查询数据
		@RequestMapping("getRoomById.action")
		public String getRoomById(String id, Map<String, Object> map) {
			Room room = this.roomDAO.getRoomById(id);
			map.put("room", room);
			return "admin/editroom";
		}
		
	//删除操作
		@RequestMapping("deleteRoom.action")
		public String deleteRoom(String id) {
			this.roomDAO.deleteRoom(id);
			return "redirect:/room/getAllRoom.action";
		}
		
	

	// 遍历教室
	@RequestMapping("getAllRoom.action")
	public String getAllRoom(String number, Map<String, Object> map) {
		
		List<Room> roomList = new ArrayList<Room>();
		List<Room> tempList = new ArrayList<Room>();
		tempList = this.roomDAO.getAllRoom();
		int pageNumber = tempList.size();
		int maxPage = pageNumber;
		if (maxPage % 10 == 0) {
			maxPage = maxPage / 10;
		} else {
			maxPage = maxPage / 10 + 1;
		}
		if (number == null) {
			number = "0";
		}
		int start = Integer.parseInt(number) * 10;
		int over = (Integer.parseInt(number) + 1) * 10;
		int count = pageNumber - over;
		if (count <= 0) {
			over = pageNumber;
		}
		for (int i = start; i < over; i++) {
			Room room = tempList.get(i);
			roomList.add(room);
		}
		String html = "";
		StringBuffer buffer = new StringBuffer();
		buffer.append("&nbsp;&nbsp;共为");
		buffer.append(maxPage);
		buffer.append("页&nbsp; 共有");
		buffer.append(pageNumber);
		buffer.append("条&nbsp; 当前为第");
		buffer.append((Integer.parseInt(number) + 1));
		buffer.append("页 &nbsp;");
		if ((Integer.parseInt(number) + 1) == 1) {
			buffer.append("首页");
		} else {
			buffer.append("<a href=\"room/getAllRoom.action?number=0\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer.append("<a href=\"room/getAllRoom.action?number=" + (Integer.parseInt(number) - 1) + "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (maxPage <= (Integer.parseInt(number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer.append("<a href=\"room/getAllRoom.action?number=" + (Integer.parseInt(number) + 1) + "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (maxPage <= (Integer.parseInt(number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer.append("<a href=\"room/getAllRoom.action?number=" + (maxPage - 1) + "\">尾页</a>");
		}
		html = buffer.toString();
		map.put("html", html);
		map.put("roomList", roomList);
		return "admin/listroom";
		
		
		
		
	}
	
	
	
	 public RoomDAO getRoomDAO() {
			return roomDAO;
		}

		public void setRoomDAO(RoomDAO roomDAO) {
			this.roomDAO = roomDAO;
		}
  
}
