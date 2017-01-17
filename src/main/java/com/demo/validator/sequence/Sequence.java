package com.demo.validator.sequence;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({First.class, Default.class, Registration.class})
public interface Sequence {

}
