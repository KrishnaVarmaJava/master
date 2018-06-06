<aside class="offsidebar hide">
 <!-- START Off Sidebar (right)-->
 <nav>
  <div role="tabpanel">
   <!-- Nav tabs-->
   <ul role="tablist" class="nav nav-tabs nav-tabs-inline nav-justified">

    <li role="presentation" ><a href="#app-settings"
     aria-controls="app-chat" role="tab" data-toggle="tab"> <em
      class="material-icons">settings</em>
    </a></li>
   </ul>
   <!-- Tab panes-->
   <div class="tab-content">

    <div id="app-settings" role="tabpanel" class="tab-pane fade active in">
     <div class="demo-settings ">
      <ul class="setting-list">
       <h2>Employee Settings</h2>
       <c:if test="${Role.equals('MANAGER_ROLE')}">
       <li><span>Manager On Leave</span>
        <div class="switch">
        <button type="button" id="switchbutton" class="btn btn-primary btn-circle  sidebar-btn-circle waves-effect waves-circle waves-float">
                                                        <i class="material-icons">person</i>
                                                    </button>
                                                    
          <button type="button" id="switchbutton1" class="btn btn-primary btn-circle  sidebar-btn-circle waves-effect waves-circle waves-float">
                                                        <i class="material-icons fa fa-close"></i>
                                                    </button>

        </div>
        
       <div style="padding:10px;" id="sidebarform" > 
        
        <div class="form-group">
           <div class="input-group addon-line">
            <div class="form-line">
             <label>Manager Name</label> <select class="form-control" size="1">
             <option value="0">Please select</option>
             <%-- <option value="${desig.getDesignation()}">${desig.getDesignation()}</option> --%>
             </select>
            </div>
           </div>
          </div>
          
          <div class="form-group">
           <div class="input-group addon-line">
            <div class="form-line">
             <label>From Date </label> <input type="date" class="form-control" placeholder="From Date" name="fromdate" id="fromdate">
            </div>
            <span class="input-group-addon"><i class="material-icons">date_range </i></span>
           </div>
          </div>
          
          <div class="form-group">
           <div class="input-group addon-line">
            <div class="form-line">
             <label>To Date </label> <input type="date" class="form-control" placeholder="To Date" name="todate" id="todate">
            </div>
            <span class="input-group-addon"><i class="material-icons">date_range </i></span>
           </div>
          </div>
    		 
    		  <div>
				<button type="button"
				class="btn btn-primary  pull-right waves-effect ">Change</button>
			</div>
    		     
         </div>

        </li>
</c:if>
      </ul>
     </div>
    </div>
   </div>
  </div>
 </nav>
 <!-- #END# Off Sidebar (right)-->
</aside>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>

$(document).ready(function(){
 $("#sidebarform").css("display","none");
 $("#switchbutton1").css("display","none");

     $("#switchbutton").click(function (event){
    	    $("#switchbutton1").css("display","block");
      $("#sidebarform").css("display","block");
      $("#switchbutton").css("display","none");
      
  
     
      });

     $("#switchbutton1").click(function (event){
    	   
         $("#sidebarform").css("display","none");
         $("#switchbutton").css("display","block");
         $("#switchbutton1").css("display","none");
         });
     
});



</script>