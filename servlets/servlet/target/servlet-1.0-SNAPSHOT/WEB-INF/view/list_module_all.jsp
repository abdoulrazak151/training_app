<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"/>
     <div class="container mt-4">
            <div class="card ">

                <div class="card-header">
                 <a href="${pageContext.request.contextPath}/module?action=all">
                    <button type="button" class="btn btn-outline-primary">+Ajouter une Formation</button>
                 </a>
                </div>

                <div class="card-body">
                    <table class="table table-hover col-sm-6">
                        <thead>
                          <tr>
                            <th scope="col">#</th>
                            <th scope="col">Denomination</th>
                            <th scope="col">Nombre de Module</th>
                            <th scope="col">Action</th>
                          </tr>
                        </thead>
                        <tbody>
                          <c:forEach var="l" items="${modules}">
                          <tr>
                            <th scope="row">${l.getId()}</th>
                            <td>${l.getName()}</td>
                            <td>Otto</td>
                            <td><a href="">voir</a>   <a href="">modifier</a>   <a href=""> Supprimer</a></td>
                          </tr>
                        </c:forEach>
                          <tr>
                            <th scope="row">2</th>
                            <td>Jacob</td>
                            <td>Thornton</td>
                            <td>@fat</td>
                          </tr>
                          <tr>
                            <th scope="row">3</th>
                            <td colspan="2">Larry the Bird</td>
                            <td>@twitter</td>
                          </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
<jsp:include page="body.jsp"></jsp:include>