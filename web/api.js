var api = window.api || {}

api.entity = (function(){
  var entities 
  var OneEntity = function(id,name,parentid,level,sort){
    if (id !== undefined) this.id = id ;
    this.name = name ;
    if (level !== undefined)  this.level = level ;
    if (parentid !== undefined)  this.parentid = parentid ;
    if (id !== sort)  this.sort = sort ;
    this.children = []
    this.active = false 
    
    this.listMetadata = function(){
      var rst = []
      for ( var m of metadata ) {
        if ( m.entityid = this.id){
          rst.push(m)
        }
      }
      return rst
    }
  }
  
  var EntityTree = function(){}
  EntityTree.prototype = {
    add : function(name,level,parentid){
      var e = new OneEntity(name,level);
      if (parentid) e.parentid = parentid ;
      
      var parent = this.getById(parentid,level)
      var siblings = parent?(parent.children = parent.children || []) : entities
      e.sort = (siblings.length +1)
      e.id = parseInt((parentid?parentid+'':'') +  e.sort) 
      
      siblings.push(e)
      return e 
    },rename : function(id,name){
      this.getById(id).name = name 
    },getById : function(id,level){
      if (id === null || id === undefined) return null ;
      
      var rec = function(arr,id,level){
        if ( !arr || arr.length == 0 )  return ;
        if (level !== null && level !== undefined && level < arr[0].level) return ;
        
        for ( var e of arr ) {
          if ( e.id == id ) return e ;
          if ( e.children && e.children.length > 0 ){
            var rst = rec(e.children,id,level);
            if ( rst ) return rst ;
          }
        }
      }
      return rec(entities,id,level)
    },sort : function(parentid,level){
      var parent = this.getById(entities,parentid,level)
      var siblings = parent?(parent.children = parent.children || []) : entities
      siblings.sort(function(e1,e2){return e1.sort - e2.sort })
    },load : function(){
      var raw = (window.entities || []).sort(function(e1,e2){
        if ( e1.level == e2.level) return e1.sort - e2.sort 
        return e1.level - e2.level 
      })
      entities = []
      for (var e of raw){
        var oe = new OneEntity(e.id,e.name,e.parentid,e.level,e.sort)
        if ( e.parentid || e.parentid == 0 ) {
          var parentEntity = this.getById(e.parentid,e.level);
          if ( !parentEntity ){
            alert('entity: parentid =' +e.parentid + ' not found')
            throw 'entity: parentid =' +e.parentid + ' not found'
          }
          parentEntity.children.push(oe)
        }else{
          entities.push(oe)
        }
      }
      return entities
    }
  }
  return new EntityTree();

})()