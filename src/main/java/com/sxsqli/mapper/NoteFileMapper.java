package com.sxsqli.mapper;

import com.sxsqli.domain.NoteFile;

import java.util.List;

public interface NoteFileMapper {
    int insert(NoteFile noteFile);
    int delete(NoteFile noteFile);
    List<NoteFile> findAll();
    List<NoteFile> findByNoteFile(NoteFile noteFile);
    List<NoteFile> findLike(String filename);
}
