document.addEventListener('DOMContentLoaded', function() {
  

  var showEntity = function(e){
    var eid = e.getAttribute('entityid')
    var data = api.entity.getById(eid)
    
    if ( data ) {
      mainPaneData.entity = data 
      mainPaneData.metadataList = data.listMetadata()
      debugger;
    }
  }
  
  var $entityList = document.getElementById('entity-list');
  //createEntityList($entityList)
  
  var clickOnEntityList = (function(){
    var subPath = function(path,$container){
      var thisIndex = 0;
      for ( ;thisIndex < path.length;thisIndex++){
        if (path[thisIndex] == $container) break ;
      }
      if (event.path[0] == window) {
        return path.slice(thisIndex+1)
      }else{
        return path.slice(0,thisIndex)
      }
    }
    
    return function(event){
      // unactive all
      $entityList.querySelectorAll('.active').forEach(function(e){
        e.className = e.className.replace(/active/g,'').replace(/bd-sidenav-active/g,'').trim()
      })
      // active clicked area
      subPath(event.path,this.$el).forEach(function(e){
        switch(e.tagName){
          case 'DIV' : e.className += ' active';break;
          case 'LI' : e.className += ' active bd-sidenav-active';break;
          case 'A' : showEntity(e)
        }
      })
    }
  })()

  window.entities = api.entity.load()
  mainPaneData = {'entities':entities,entity:window.entities[0]||{}}
  mainPaneData.metadataList = mainPaneData.entity.listMetadata()
  new Vue({
    el: '#entity-list',
    data : mainPaneData,
    methods : {
      clickOnEntityList : clickOnEntityList,
      isActive : function(e){
        return !!e.active
      }
    }
  })
  var main = new Vue({
    el: 'main',
    data: mainPaneData
  })
});
