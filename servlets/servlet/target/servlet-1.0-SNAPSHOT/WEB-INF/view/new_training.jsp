<jsp:include page="header.jsp"/>
     <div class="container mt-4">
            <div class="card ">
                <div class="card-header">

                </div>
                <div class="card-body">
                           <form action="${pageContext.request.contextPath}/home?action=create_training" method="post">
                                   <div class="input-group mb-3">
                                             <span class="input-group-text" id="basic-addon1">Training Name</span>
                                             <input type="text" class="form-control" placeholder="name" name="name" aria-label="name" aria-describedby="basic-addon1">
                                       </div>
                    <div class="col-12">
                        <button class="btn btn-primary" type="submit">creer</button>
                    </div>
                    </form>

                </div>
            </div>
     </div>
<jsp:include page="body.jsp"></jsp:include>