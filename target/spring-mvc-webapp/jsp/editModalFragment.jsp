<div class="modal fade" id="dvd-edit-modal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    &times;
                </button>
            </div>
            <div class="modal-body">
                <h3 id="edit-dvd-id"></h3>
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="edit-dvd-title" class="col-md-4 control-label">Title:</label>
                        <div class="col-md-8">
                            <input id="edit-dvd-title" name="dvdTitle" type="text" class="form-control" placeholder="Title"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-dvd-releasedate" class="col-md-4 control-label">Release Date:</label>
                        <div class="col-md-8">
                            <input id="edit-dvd-releasedate" name="dvdReleaseDate" type="text" class="form-control" placeholder="Release Date"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-dvd-mpaarating" class="col-md-4 control-label">MPAA Rating:</label>
                        <div class="col-md-8">
                            <input id="edit-dvd-mpaarating" name="dvdMpaaRating" type="text" class="form-control" placeholder="MPAA Rating"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-dvd-director" class="col-md-4 control-label">Director:</label>
                        <div class="col-md-8">
                            <input id="edit-dvd-director" name="dvdDirector" type="text" class="form-control" placeholder="Director"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-dvd-studio" class="col-md-4 control-label">Studio:</label>
                        <div class="col-md-8">
                            <input id="edit-dvd-studio" name="dvdStudio" type="text" class="form-control" placeholder="Studio"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-dvd-usernote" class="col-md-4 control-label">User Note:</label>
                        <div class="col-md-8">
                            <input id="edit-dvd-usernote" name="dvdUserNote" type="text" class="form-control" placeholder="User Note"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-8">
                            <button type="submit" id="edit-button" class="btn btn-default" data-dismiss="modal">Edit DVD</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="close" data-dismiss="modal">
                    Close
                </button>
            </div>
        </div>
    </div>
</div>