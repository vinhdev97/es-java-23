package com.vinhdev97.es.api.service.search;

import java.util.List;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.RowBounds;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/services")
public class ServiceSearchController {

  private final ServiceSearchService serviceSearchService;

  @GetMapping
  public ResponseEntity<List<ServiceSearchResponse>> search(
      @RequestParam @Nullable Long id,
      @RequestParam @Nullable String name,
      @RequestParam(defaultValue = "20") @Nullable int size,
      @RequestParam(defaultValue = "1") @Nullable int page) {
    ServiceSearchRequest request = new ServiceSearchRequest(id, name, size, page);
    RowBounds rowBounds = new RowBounds((page < 1 ? 1 : page - 1) * size, size);

    return ResponseEntity.ok(
        serviceSearchService.execute(request, rowBounds));
  }
}
