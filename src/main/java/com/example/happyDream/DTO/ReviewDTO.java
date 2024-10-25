package com.example.happyDream.DTO;

import com.example.happyDream.Entity.ChargerEntity;
import com.example.happyDream.Entity.ReviewEntity;
import com.example.happyDream.Entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ReviewDTO {
    //리뷰 데이터
    private Integer id;
    private ChargerEntity chargerId;  // 수정: ChargerEntity 대신 Integer
    private UserEntity userId;     // 수정: UserEntity 대신 Integer
    private String reviewContent;
    private Byte rating;
    
    //관리 목적 데이터
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Boolean deletedYn;
    private LocalDateTime deletedAt;

    @Builder
    public ReviewDTO(Integer id, ChargerEntity chargerId, UserEntity userId, String reviewContent, Byte rating, LocalDateTime createdAt, LocalDateTime modifiedAt, Boolean deletedYn, LocalDateTime deletedAt) {
        this.id = id;
        this.chargerId = chargerId;
        this.userId = userId;
        this.reviewContent = reviewContent;
        this.rating = rating;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.deletedYn = deletedYn;
        this.deletedAt = deletedAt;
    }

    public ReviewEntity toEntity() {
        return ReviewEntity.builder()
                .id(id)
                .chargerId(chargerId)
                .userId(userId)
                .reviewContent(reviewContent)
                .rating(rating)
                .createdAt(createdAt)
                .modifiedAt(modifiedAt)
                .deletedYn(deletedYn)
                .deletedAt(deletedAt)
                .build();
    }
}
