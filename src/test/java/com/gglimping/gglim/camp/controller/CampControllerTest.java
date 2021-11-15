package com.gglimping.gglim.camp.controller;


import com.gglimping.gglim.camp.dtos.RequestFetchCamps;
import com.gglimping.gglim.camp.dtos.ResponseCamp;
import com.gglimping.gglim.camp.dtos.ResponseFetchCamps;
import com.gglimping.gglim.camp.service.CampService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class CampControllerTest {
    @InjectMocks
    CampController subject;

    @Mock
    CampService mockCampService;

    @DisplayName("should return camp list")
    @Test
    void getFetchCamps() {
        RequestFetchCamps request = new RequestFetchCamps(6L, 6);
        List<ResponseFetchCamps> responses = List.of(ResponseFetchCamps
                .builder()
                .id(1L)
                .address("서울특별시 관악구 남현동 1234-12")
                .name("끌림핑장")
                .price("60000")
                .rating("4.2")
                .imageUrls(List.of("domain.com/resource1", "domain.com/resource2", "domain.com/resource3"))
                .build());

        ResponseEntity<List<ResponseFetchCamps>> responseEntity = ResponseEntity.ok(responses);

        given(mockCampService.fetchCampsBy(request.getLastCampId(), request.getSize())).willReturn(responses);

        ResponseEntity<List<ResponseFetchCamps>> result = subject.getFetchCamps(request);


        then(mockCampService).should().fetchCampsBy(6L, 6);
        assertThat(result.getStatusCode()).isEqualTo(responseEntity.getStatusCode());
        assertThat(Objects.requireNonNull(result.getBody()).get(0)).isEqualTo(Objects.requireNonNull(responseEntity.getBody()).get(0));
        assertThat(Objects.requireNonNull(result.getBody()).get(0).getAddress()).isEqualTo(Objects.requireNonNull(responseEntity.getBody()).get(0).getAddress());
        assertThat(Objects.requireNonNull(result.getBody()).get(0).getName()).isEqualTo(Objects.requireNonNull(responseEntity.getBody()).get(0).getName());
        assertThat(Objects.requireNonNull(result.getBody()).get(0).getId()).isEqualTo(Objects.requireNonNull(responseEntity.getBody()).get(0).getId());
        assertThat(Objects.requireNonNull(result.getBody()).get(0).getPrice()).isEqualTo(Objects.requireNonNull(responseEntity.getBody()).get(0).getPrice());
        assertThat(Objects.requireNonNull(result.getBody()).get(0).getRating()).isEqualTo(Objects.requireNonNull(responseEntity.getBody()).get(0).getRating());
        assertThat(Objects.requireNonNull(result.getBody()).get(0).getImageUrls().size()).isEqualTo(Objects.requireNonNull(responseEntity.getBody()).get(0).getImageUrls().size());
    }

    @Nested
    class getCamps {
        @Test
        void 일반적인_경우() throws Exception {
            ResponseCamp responseCamp = ResponseCamp.builder()
                    .id(1L)
                    .name("끌림핑")
                    .summary("안녕하세요.")
                    .rating("4.2")
                    .ratingCnt("10")
                    .phone("010-1234-1234")
                    .url("www.gglim.com")
                    .checkIn("2021-10-12 15:00")
                    .checkOut("2021-10-13 11:00")
                    .description("안녕하세요.")
                    .imgUrls(List.of("url1", "url2", "url3"))
                    ._x_loc("0.12345")
                    ._y_loc("12.34567").build();

            given(mockCampService.getCampBy(1L)).willReturn(responseCamp);
            ResponseEntity<ResponseCamp> responseEntity = ResponseEntity.ok(responseCamp);

            ResponseEntity<ResponseCamp> result = subject.getCamps(1L);
            assertThat(result.getBody().getId()).isEqualTo(responseEntity.getBody().getId());
        }

        @Test
        void 데이터를_찾을_수_없는_경우() throws Exception {
            given(mockCampService.getCampBy(3L)).willThrow(new Exception("data is not found."));

            try{
                ResponseEntity<ResponseCamp> result = subject.getCamps(3L);
            } catch(Exception e) {
                assertThat(e instanceof Exception).isTrue();
                assertThat(e.getMessage()).isEqualTo(e.getMessage());
            }
        }
    }

}
