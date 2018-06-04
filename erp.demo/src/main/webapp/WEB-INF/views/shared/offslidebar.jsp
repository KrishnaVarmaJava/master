
<aside class="offsidebar hide">
	<!-- START Off Sidebar (right)-->
	<nav>
		<div role="tabpanel">
			<!-- Nav tabs-->
			<ul role="tablist" class="nav nav-tabs nav-tabs-inline nav-justified">

				<li role="presentation"><a href="#app-settings"
					aria-controls="app-chat" role="tab" data-toggle="tab"> <em
						class="material-icons">settings</em>
				</a></li>
			</ul>
			<!-- Tab panes-->
			<div class="tab-content">

				<div id="app-settings" role="tabpanel" class="tab-pane fade">
					<div class="demo-settings ">
						<ul class="setting-list">
							<h2>Layout Settings</h2>
							<li><span>Fixed</span>
								<div class="switch">
									<label><input id="chk-fixed" type="checkbox"
										data-toggle-state="trigger-element"><span
										class=" lever switch-col-grey make-switch switch-on"></span></label>

									<div class="trigger-element">hai</div>
									
									
								</div>
								

								</li>

						</ul>
					</div>
				</div>
			</div>
		</div>
	</nav>
	<!-- #END# Off Sidebar (right)-->
</aside>

<script>
$(document).ready(function() {
    $('.switch-on').on('switch-change', function (e, data) {
        var $el = $(data.el)
          , value = data.value;
        if(value){//this is true if the switch is on
           $('.name-number-form').show();
        }else{
           $('.name-number-form').hide();
        }
    });
});
</script>
