angular.module('doecode_app', [])
  .controller('project_list_controller', function() {
    var project_list = this
    project_list.projects = [
      {title: 'A Really Important Project'},
      {title: 'Something Complicated'}
    ]
    
    project_list.add_project = function() {
      project_list.projects.push({title: project_list.title_text})
      project_list.title_text = ''
    }
})

