<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
ul {
	padding-left: 20px;
}

img {
	margin-right: 5px;
	width: 8px;
	height: 8px;
	margin-bottom: 2px;
}

ul li ul {
	display: none;
}

ul li {
	list-style: none;
}
</style>
<script src="js/jquery-2.1.1.min.js"></script>
<script>
	$(document).ready(function(e) {
		$("ul li a img").click(function(e) {
			var chidren = $(this).parent().siblings("ul");
			if (chidren.css("display") == "none") {
				$(this).attr("src", "images/unfold2.gif");
				//chidren.css("display", "block");
				chidren.slideDown();

			} else if (chidren.css("display") == "block") {
				$(this).attr("src", "images/fold.gif");
				//chidren.css("display", "none");
				chidren.slideUp();
			} else {
				$(this).attr("src", "images/disc.gif");
			}
		});
	});
</script>
</head>
<body>
	<ul>
		<li><a><img src="images/fold.gif" /></a><a href="#"><s:property
					value="organization.name" /> </a> <s:if
				test="organization.children.size > 0">
				<ul>
					<s:iterator value="organization.children">
						<li><a><img src="images/fold.gif" /></a><a href="#"><s:property
									value="name" /> </a> <s:if test="children.size > 0">
								<ul>
									<s:iterator value="children">
										<li><a><img src="images/fold.gif" /></a><a href="#"><s:property
													value="name" /> </a> <s:if test="children.size > 0">
												<ul>
													<s:iterator value="children">
														<li><a><img src="images/fold.gif" /></a><a href="#"><s:property
																	value="name" /> </a></li>
													</s:iterator>
												</ul>
											</s:if>
									</s:iterator>
								</ul>
							</s:if></li>
					</s:iterator>
				</ul>
			</s:if></li>
	</ul>
</body>
</html>