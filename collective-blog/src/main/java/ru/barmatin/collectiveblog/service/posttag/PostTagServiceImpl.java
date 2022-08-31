package ru.barmatin.collectiveblog.service.posttag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.collectiveblog.domain.PostTag;
import ru.barmatin.collectiveblog.repository.PostTagRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostTagServiceImpl implements PostTagService {
    private final PostTagRepository postTagRepository;

    @Autowired
    public PostTagServiceImpl(PostTagRepository postTagRepository) {
        this.postTagRepository = postTagRepository;
    }

    @Override
    public List<PostTag> getExistingPostTagList(List<PostTag> postTags) {
        List<String> nameList = new ArrayList<>();
        for (PostTag postTag: postTags) {
            nameList.add(postTag.getName());
        }
        List<PostTag> postTagList = postTagRepository.findPostTagByNameList(nameList);
        for (PostTag postTag: postTags) {
            if (!postTagList.contains(postTag)) {
                postTagList.add(postTag);
            }
        }
        return postTagList;
    }

}
