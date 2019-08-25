document.addEventListener('DOMContentLoaded', function() {
  
  var getUrlQuery = function(path){
    var querystring = path || location.search
    // querystring can be 
    // 1. '?'
    // 2. '?a=1&b=2'
    // 3. <empty>
    var params = {}
    if ( querystring ){
      var index = querystring.indexOf('?')
      if( index != -1 ) {
        querystring = querystring.substring(index+1)
      }
      if( querystring ){ 
        for(var kv of querystring.split('&')){
          var kvarr = kv.split('=')
          if( kvarr && kvarr.length > 0 && kvarr[0]){
            params[kvarr[0]] = kvarr[1] || ''
          }
        }
      }
    }
    return params  
  }
  
  var mainPaneData = {}
  var init = function(){
    var entities = api.entity.load()
    var entityid = getUrlQuery()['entityid']
    var entity = entityid ? api.entity.getById(entityid): (entities[0]||{} )
    var metadataList = entity && entity.id ? entity.listMetadata() : []
    
    mainPaneData.entities = entities
    mainPaneData.entity = entity
    mainPaneData.metadataList = metadataList
    debugger
    
  }
  init()
  new Vue({
      el: '.container-fluid',
      data : mainPaneData
    })
});
