<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp"/>
     <div class="container mt-4">
            <div class="card ">

                <div class="card-header">
                 <a href="${pageContext.request.contextPath}/home?action=training">
            
                    <button type="button" class="btn btn-outline-primary">+Ajouter une Formation</button>
                 </a>
                </div>

                <div class="card-body">
                    <table class="table table-hover col-sm-6">
                        <thead>
                          <tr>
                            <th scope="col">#</th>
                            <th scope="col">Denomination</th>
                            <th scope="col">Nombre d'etudiant</th>
                            <th scope="col">Action</th>
                          </tr>
                        </thead>
                        <tbody>

                          <c:forEach var="l" items="${trainings}">
                          <tr>
                            <th scope="row">${l.getId()}</th>
                            <td>${l.getName()}</td>
                            <td>${l.nbrOfStudents()}</td>
                            <td><a href="${pageContext.request.contextPath}/module?action=list_module&id=${l.getId()}">voir</a>   <a href="${pageContext.request.contextPath}/module?action=update_training&id=${l.getId()}">modifier</a>   <a href="${pageContext.request.contextPath}/module?action=delete_training&id=${l.getId()}"> Supprimer</a></td>
                          </tr>
                        </c:forEach>
                         
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
<jsp:include page="body.jsp"></jsp:include>