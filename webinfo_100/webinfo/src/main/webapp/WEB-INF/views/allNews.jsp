<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO8859-1">

<jsp:include page="head.jsp" flush="true" />
<title>News</title>
</head>
<body>
	<jsp:include page="header.jsp" flush="true" />
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1><spring:message
							code="addNews.allNews.label" /></h1>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<c:forEach items="${news}" var="news">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<div style="height: 70px;">
							<h3 style="text-decoration: none" class="text-dark">
									${news.type} 
							</h3>
							</div>

							<p>${news.headline}</p>
							<div style="height: 50px;">
								<p>${news.description}</p>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>