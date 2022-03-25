<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"/>
     <div class="container mt-4">
            <div class="card ">

                <div class="card-header">
                 <a href="${pageContext.request.contextPath}/module?action=new_module&id=${id_training}">
                    <button type="button" class="btn btn-outline-primary">+Ajouter un module</button>
                 </a>
                </div>

                <div class="card-body">
                    <table class="table table-hover col-sm-6">
                        <thead>
                          <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">description</th>
                            <th scope="col">duration</th>
                            <th scope="col">Action</th>
                          </tr>
                        </thead>
                        <tbody>
                          <c:forEach var="m" items="${modules}">
                          <tr>
                            <th scope="row">${m.getId()}</th>
                            <td>${m.getName()}</td>
                            <td>${m.getDescription()}</td>
                            <td>${m.getDuration()}</td>
                            <td><a href="${pageContext.request.contextPath}/module?action=view&id=${m.getId()}">voir</a>   <a href="${pageContext.request.contextPath}/module?action=update&id=${m.getId()}">modifier</a>   <a href="${pageContext.request.contextPath}/module?action=delete&id=${m.getId()}"> Supprimer</a></td>
                          </tr>
                        </c:forEach>
                         
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
<jsp:include page="body.jsp"></jsp:include>