package com.sparta.week03.controller;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRepository;
import com.sparta.week03.domain.MemoRequestDTO;
import com.sparta.week03.sevice.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;


    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDTO requestDTO) {
        Memo memo = new Memo(requestDTO);
        return memoRepository.save(memo);
    }

    @GetMapping("/api/memos")

    public List<Memo> getMemos() {
        LocalDateTime startDatetime = LocalDateTime.now().minusDays(1);
        LocalDateTime endDatetime = LocalDateTime.now();
        return memoRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(startDatetime , endDatetime);
    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDTO requestDTO){
        memoService.update(id, requestDTO);
        return id;
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return id;
    }


}
