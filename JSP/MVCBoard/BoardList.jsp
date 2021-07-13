<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="mvcboard.model.*,mvcboard.command.*" %>
<%@ page import="java.util.List" %>

<%  //웹브라우저가 게시글 목록을 캐싱할 경우 새로운 글이 추가되더라도 새글이 목록에 안 보일 수 있기 때문에 설정
	response.setHeader("Pragma","No-cache");		// HTTP 1.0 version
	response.setHeader("Cache-Control","no-cache");	// HTTP 1.1 version
	response.setHeader("Cache-Control","no-store"); // 일부 파이어폭스 버스 관련
	response.setDateHeader("Expires", 1L);			// 현재 시간 이전으로 만료일을 지정함으로써 응답결과가 캐쉬되지 않도록 설정
%>

<%
	String pNum = request.getParameter("page");
// 현제 페이지 값을 파라미터로 받음


// 전체 메세지 레코드 검색

List<BoardVO> mList = (List<BoardVO>)request.getAttribute("mList"); 

Object oj = request.getAttribute("total");

int totalPage = Integer.parseInt(oj.toString());

int pageCount = 5;
// 몇 페이지를 그룹으로 묶을건지 지정

	if(pNum == null)
		pNum = "1";
	// 페이지수가 없을경우 1페이지로 인식함
	int pageNum = Integer.parseInt(pNum);
 	// pNum을 int형으로 형변환
	if(pageNum < 1)
		response.sendRedirect("/MVCBoard/BoardControl?cmd=list&page=1");
	// 페이지가 음수로 넘어갈 경우 1페이지로 리다이렉트
	
	int maxPage = (int)Math.ceil((double)pageNum / (double)pageCount)*pageCount;
	// 현재 페이지의 최대 페이지 지정 (현재 페이지를 pageCount의 배수로 변환)
	int minPage = maxPage-(pageCount-1);
	/* // 현재 페이지의 최소 페이지 지정
	int totalPage = CommandList.getInstance().getTotalCount(); */
	// 전체 최대 페이지수를 가져옴
	if(maxPage > totalPage)
		maxPage = totalPage;
	// 현재 최대 페이지 수가 전체 최대 페이지수를 넘을 경우 현재 최대 페이지를 전체 최대 페이지로 변경
	if(pageNum > totalPage)
		response.sendRedirect("/MVCBoard/BoardControl?cmd=list&page=" + totalPage);
	// 현재 페이지가 전체 최대 페이지를 넘어갈 경우 전체 최대 페이지로 리다이렉트함
%>

<HTML>
<head><title> 게시글 목록 </title>
</head>

<BODY>

	<h3> 게시판 목록 </h3>
	
	<table border="1" bordercolor="darkblue">
	<tr>
		<td> 글번호 </td>
		<td> 제 목 </td>
		<td> 작성자 </td>
		<td> 작성일 </td>
		<td> 조회수 </td>
	</tr>
	
	<% if( mList == null ) { %>
		<tr><td colspan="5"> 등록된 게시물이 없습니다. </td></tr>
	<% } else { 
	for(BoardVO vo : mList){
	%>
	<tr>
	<td><%=vo.getSeq() %></td>
	<td><a href='/MVCBoard/BoardControl?cmd=view&seq=<%=vo.getSeq() %>&page=<%=pNum%>'><%=vo.getTitle() %></a></td>
	<td><%=vo.getWriter() %></td>
	<td><%=vo.getRegdate().substring(0, 10) %></td>
	<td><%=vo.getCnt() %></td>
	</tr>
	<% }}  %>
		<tr>
			<td colspan="5">
				<button type="button" onclick="location.href='/MVCBoard/BoardControl?cmd=input-form'">글작성</button>
				<a href='/MVCBoard/BoardControl?cmd=list&page=<%=pageNum-5 %>'>◀</a>
				<% for(int i=minPage; i<=maxPage; i++){ %>
				<a href='/MVCBoard/BoardControl?cmd=list&page=<%=i%>'>[<%=i %>]</a>
				<%} %>
				<a href='/MVCBoard/BoardControl?cmd=list&page=<%=pageNum+5 %>'>▶</a>
			</td>
		</tr>
	</table>
</BODY>
</HTML>
