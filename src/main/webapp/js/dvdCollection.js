/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    
    loadDVDs();
    
    $("#add-button").click(function(event){
        event.preventDefault();
        addDVD();
    });
    
    $("#dvd-details-modal").on('show.bs.modal', function(event){
        var element = $(event.relatedTarget);
        var dvdId = element.data('dvd-id');
        dvdDetails(dvdId);
    });
    
    $("#dvd-edit-modal").on('show.bs.modal', function(event){
        var element = $(event.relatedTarget);
        var dvdId = element.data('dvd-id');
        dvdEditDetails(dvdId);
    });
    
    $("#edit-button").click(function(event){
        event.preventDefault();
        editDVD();
    });
    
    
    
});

//===========
//FUNCTIONS
//===========

function clearTable(){
    $('#dvdRows').empty();
}


function processDVDList(dvds){
    
    clearTable();
    
    var dvdRows = $('#dvdRows');
    
    $.each(dvds, function (index, dvd) {
        
        var titleField = $("<td>");
        var releaseDateField = $("<td>");
        var editField = $("<td>");
        var deleteField = $("<td>");
        
        var titleLink = $("<a>");
        titleLink.attr({'data-toggle':'modal', 'data-target':'#dvd-details-modal', 'data-dvd-id':dvd.id});
        titleLink.text(dvd.title);
        titleField.append(titleLink);
        
        releaseDateField.text(dvd.releaseDate);
        
//        edit link
        var editLink = $("<a>");
        editLink.attr({
            'data-toggle':'modal',
            'data-target': '#dvd-edit-modal',
            'data-dvd-id':dvd.id
        });
        editLink.text("Edit");
        editField.append(editLink);
        
//        delete link
        var deleteLink = $("<a>");
        deleteLink.attr({
            'onclick' : 'deleteDVD('+dvd.id+')'
        });
        deleteLink.text("Delete");
        deleteField.append(deleteLink);
        
        var dvdRow = $("<tr>");
        dvdRow.append(titleField);
        dvdRow.append(releaseDateField);
        dvdRow.append(editField);
        dvdRow.append(deleteField);
        
        dvdRows.append(dvdRow);
        
    });
    
}

function loadDVDs(){ 
    
    $.ajax({
        url : 'dvds',
        type : 'GET'
    }).success(function (data){
        processDVDList(data);
    });
}


function addDVD() {
    
    var dvdTi = $("#add-title").val();
    var dvdRDate = $("#add-release-date").val();
    var dvdRate = $("#add-mpaa-rating").val();
    var dvdDir = $("#add-director").val();
    var dvdSt = $("#add-studio").val();
    var dvdNote = $("#add-user-note").val();
    
    $.ajax({
        url : 'dvd',
        type : 'POST',
        headers : {
            'Accept' : 'application/json',
            'Content-type' : 'application/json'
        },
        'dataType' : 'json',
        
        data : JSON.stringify({
            title : dvdTi,
            releaseDate : dvdRDate,
            mpaaRating : dvdRate,
            director : dvdDir,
            studio : dvdSt,
            userNote : dvdNote
        })
        
    }).success(function(data){
        loadDVDs();
    });
    
}

function dvdDetails(id){
    $.ajax({
        type: 'GET',
        url: 'dvd/' + id,
        headers: {
            'Accept': 'application/json'
        }
    }).success(function(dvd){
        $("#dvd-detail-id").text(dvd.id);
        $("#dvd-detail-title").text(dvd.title);
        $("#dvd-detail-releasedate").text(dvd.releaseDate);
        $("#dvd-detail-mpaarating").text(dvd.mpaaRating);
        $("#dvd-detail-director").text(dvd.director);
        $("#dvd-detail-studio").text(dvd.studio);
        $("#dvd-detail-usernote").text(dvd.userNote);
    });
}

function dvdEditDetails(id){
    $.ajax({
        type: 'GET',
        url: 'dvd/' + id,
        headers: {
            'Accept': 'application/json'
        }
    }).success(function(dvd){
        $("#edit-dvd-id").text(dvd.id);
        $("#edit-dvd-title").val(dvd.title);
        $("#edit-dvd-releasedate").val(dvd.releaseDate);
        $("#edit-dvd-mpaarating").val(dvd.mpaaRating);
        $("#edit-dvd-director").val(dvd.director);
        $("#edit-dvd-studio").val(dvd.studio);
        $("#edit-dvd-usernote").val(dvd.userNote);
    });
}

function editDVD(){
    var id = $("#edit-dvd-id").text();
    var dvdTi = $("#edit-dvd-title").val();
    var dvdRDate = $("#edit-dvd-releasedate").val();
    var dvdRate = $("#edit-dvd-mpaarating").val();
    var dvdDir = $("#edit-dvd-director").val();
    var dvdSt = $("#edit-dvd-studio").val();
    var dvdNote = $("#edit-dvd-usernote").val();
    
    $.ajax({
        url: 'dvd/' + id,
        type: 'PUT',
        headers: {
            'Content-type' : 'application/json'
        },
        'dataType' : 'json',
        data : JSON.stringify({
            title : dvdTi,
            releaseDate : dvdRDate,
            mpaaRating : dvdRate,
            director : dvdDir,
            studio : dvdSt,
            userNote : dvdNote
        })
    }).success(function(data){
        loadDVDs();
    });
    
}

function deleteDVD(id){
    $.ajax({
        type: 'DELETE',
        url: 'dvd/' + id
    }).success(function(){
        loadDVDs();
    });
}
