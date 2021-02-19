<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

    <title>연락처 관리</title>
  </head>
  <body>
<div class="container-fluid">
  <div class="row no-gutter">
    <div class="d-none d-md-flex col-md-4 col-lg-6 bg-image"></div>
    <div class="col-md-8 col-lg-6">
      <div class="login d-flex align-items-center py-5">
    <aside>
<div id="namecard">   
  <img src="image/bam2.jpg" width="150" height="200"  alt="bam"></div>
    </aside>
        <div class="container">
          <div class="row">
            <div class="col-md-9 col-lg-8 mx-auto">
              <h3 class="login-heading mb-4">Welcome back!</h3>
              <form action="LoginServlet" method="post">
                <div class="form-label-group">
                  <input type="text" name="id" class="form-control" placeholder=ID required autofocus>
                  <label for="inputEmail"></label>
                </div>

                <div class="form-label-group">
                  <input type="password" name="pw" class="form-control" placeholder="Password" required>
                  <label for="inputPassword"></label>
                </div>

                <div class="custom-control custom-checkbox mb-3">
                  <label class="custom-control-label" for="customCheck1">잘못 입력하였습니다.</label>
                </div>
                <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit">Sign in</button>
                <div class="text-center">
                  <a class="small" href="JoinServlet">회원가입</a></div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>


