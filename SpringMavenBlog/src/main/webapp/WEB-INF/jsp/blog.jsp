<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello Spring Blog</title>
<link rel="stylesheet" href="/webjars/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" href="/webjars/origoni-startbootstrap-clean-blog/1.0.3/css/clean-blog.min.css">
</head>
<body>
	<!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
               <!-- <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbarNav">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button> -->
                <a class="navbar-brand" href="/blog">Start Bootstrap</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a class="nav-link" href="/blog">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li>
                        <a class="nav-link" href="#about.html">About</a>
                    </li>
                    <li>
                        <a class="nav-link" href="/post">Sample Post</a>
                    </li>
                    <li>
                        <a class="nav-link" href="#contact.html">Contact</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Header -->
    <!-- Set your background image for this header on the line below. -->
    <header class="intro-header" style="background-color: #777799">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <div class="site-heading">
                        <h1>Start Blog</h1>
                        <hr class="small">
                        <span class="subheading">A Start Blog Theme by Bootstrap</span>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Main Content -->
        <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
            
			<c:forEach var="post" items="${postList}">
				<div class="post-preview">
                    <a href="/post/${post.id}">
                        <h2 class="post-title">
                            ${post.subject}
                        </h2>
                        <h3 class="post-subtitle">
                            부 제목
                        </h3>
                    </a>
                    <p class="post-meta">Posted by <a href="#">Nows</a> on ${post.regDate}</p>
                </div>
                <hr>
					</c:forEach>
			
                <!-- Pager -->
                <ul class="pager">
                    <li class="next">
                        <a href="#">Older Posts &rarr;</a>
                    </li>
                </ul>
            </div>
        </div>
	</div>

    <hr>

    <!-- Footer -->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <ul class="list-inline text-center">
                        <li>
                            <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-twitter fa-stack-1x fa-inverse"></i>
                                </span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-facebook fa-stack-1x fa-inverse"></i>
                                </span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-github fa-stack-1x fa-inverse"></i>
                                </span>
                            </a>
                        </li>
                    </ul>
                    <p class="copyright text-muted">Copyright &copy; Your Website 2018</p>
                </div>
            </div>
        </div>
    </footer>

	<script src="/webjars/jquery/3.3.1-1/jquery.min.js"></script>
	<script src="/webjars/bootstrap/4.1.0/js/bootstrap.min.js"></script>
	<script src="/webjars/origoni-startbootstrap-clean-blog/1.0.3/js/clean-blog.min.js"></script>
</body>
</html>