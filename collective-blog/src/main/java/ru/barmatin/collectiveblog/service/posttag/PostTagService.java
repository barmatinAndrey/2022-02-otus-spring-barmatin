package ru.barmatin.collectiveblog.service.posttag;

import ru.barmatin.collectiveblog.domain.PostTag;

import java.util.List;

public interface PostTagService {

    List<PostTag> getExistingPostTagList(List<PostTag> postTagList);

}
