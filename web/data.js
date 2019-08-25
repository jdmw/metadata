entities = [{
  id : 1,
  name : 'Common',
  level : 1,
  sort : 1 
},{
  id : 2,
  name : 'User',
  level : 1,
  sort : 2 ,
},{
  id : 21,
  parentid: 2,
  name : 'Account',
  level : 2,
  sort : 1
},{
  id : 3,
  name : 'Event',
  level : 1,
  sort : 3
}];

/* template: 
  entityid : 1,
  code : 11 ,
  cname : 'ID',
  ename : 'ID',
  abbr : 'ID',
  defaultValue : 0 ,
  
  busDatatype : 1 , // 业务属性-数据类型 0:文本 1：数值 2：枚举 3：日期 4 ：时间 
  busLength : 32 ,
  busFormat : '',   // 业务属性-数据格式 ，如日期YYYY-MM-dd ，时间 hh:mm
  busUnit : '',     // 业务属性-单位 ，如:亿元'
  busRule : '',     // 业务属性-业务规则 
  options : [
    { value : 0 , name : '1' , description: '' ,isDefault : true },
    { value : 1 , name : '2' },
  ],
  
  fieldTypeId : 'ID' , // 数据元类型域
  techDatatype: 'int' ,
  techLength : 36,
  techPrecision : 0 ,
  description : ''
 */
metadata = [{
  entityid : 1,
  code : 11 ,
  cname : 'ID',
  ename : 'ID',
  abbr : 'ID',
  //defaultValue : 0 ,
  busDatatype : 1 , // 业务属性-数据类型 0:文本 1：数值 2：枚举 3：日期 4 ：时间 
  busLength : 32 ,
  busFormat : '',   // 业务属性-数据格式 ，如日期YYYY-MM-dd ，时间 hh:mm
  busUnit : '',     // 业务属性-单位 ，如:亿元'
  busRule : '',     // 业务属性-业务规则 
  fieldTypeId : 'ID' , // 数据元类型域
  //techDatatype: 'int' ,
  //techLength : 36,
  //techPrecision : undefined ,
  description : 'ID'
},{
  entityid : 2,
  code : 21 ,
  cname : 'Sex',
  ename : 'Sex',
  abbr : 'SEX',
  busDatatype : 2 , // 业务属性-数据类型 0:文本 1：数值 2：枚举 3：日期 4 ：时间 
  options : [
    { value : 0 , name : 'Male' , description: '' ,isDefault : true },
    { value : 1 , name : 'FeMale' },
  ],
  fieldTypeId : 'ENUM'
},{
  entityid : 1,
  code : 12 ,
  cname : 'Date',
  ename : 'Date',
  abbr : 'DATE',
  busDatatype : 4 , // 业务属性-数据类型 0:文本 1：数值 2：枚举 3：日期 4 ：时间 
  fieldTypeId : 'DATE' , // 数据元类型域
}
]


// format
// {
//    code : 'ID' ,
//    datatype : 'int' ,
//    length : 11,
//    precision : 0,
//    description : 'ID',
// }

fieldtypes = [{
  code : 'ID' ,
  datatype : 'int' ,
  length : 11
},{
  code : 'SMALL_NAME' ,
  datatype : 'varchar' ,
  length : 10,
},{
  code : 'ENUM' ,
  datatype : 'tinyint' ,
},{
  code : 'DATE' ,
  datatype : 'date' ,
},{
  code : 'DATETIME' ,
  datatype : 'timestemp' ,
},{
  code : 'TIME' ,
  datatype : 'time' ,
}]

