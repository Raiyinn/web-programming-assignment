<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="head.jsp" flush="true" />
<title>News</title>
</head>
<body>
<jsp:include page="headerAdmin.jsp" flush="true" />
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1><spring:message
							code="addNews.allNews.label" /></h1>
				<p><spring:message
							code="addNews.addNews.label" /></p>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form method="POST" modelAttribute="newNews"
			class="form-horizontal" enctype="multipart/form-data">
			<form:errors path="*" cssClass="alert alert-danger" element="div" />

			<fieldset>
				<legend><spring:message
							code="addNews.form.addNews.label" /></legend>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="newsId"><spring:message
							code="addNews.form.newsId.label" /> </label>
					<div class="col-lg-10">
						<form:input id="newsId" path="newsId" type="text"
							class="form:input-large" />
						<form:errors path="newsId" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="type"><spring:message
							code="addNews.form.type.label" /></label>
					<div class="col-lg-10">
						<form:input id="type" path="type" type="text"
							class="form:input-large" />
						<form:errors path="type" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="headline"><spring:message
							code="addNews.form.headline.label" /></label>
					<div class="col-lg-10">
						<form:input id="headline" path="headline" type="text"
							class="form:input-large" />
						<form:errors path="headline" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="description"><spring:message
							code="addNews.form.description.label" /></label>
					<div class="col-lg-10">
						<form:textarea id="description" path="description" rows="5" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="newsImage"> <spring:message
							code="addNews.form.newsImage.label" /></label>
					<div class="col-lg-10">
						<form:input id="newsImage" path="newsImage" type="file"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Add" />
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>
