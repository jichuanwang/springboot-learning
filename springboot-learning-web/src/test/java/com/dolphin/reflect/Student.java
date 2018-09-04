package com.dolphin.reflect;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author jichuan.wang
 * @<p>:
 * @since 2018/8/29 14:16
 */
@Data
@RequiredArgsConstructor(staticName = "build")
@NoArgsConstructor
public class Student extends Human {
    @NonNull
    private String teacher;
    @NonNull
    private String number;
}
