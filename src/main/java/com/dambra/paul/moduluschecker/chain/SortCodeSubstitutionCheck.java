package com.dambra.paul.moduluschecker.chain;

import com.dambra.paul.moduluschecker.ModulusCheckParams;
import com.dambra.paul.moduluschecker.SortCodeSubstitution;

public class SortCodeSubstitutionCheck implements ModulusChainCheck{

    private final SortCodeSubstitution sortCodeSubstitution;
    private final AtLeastOneWeightRowGate next;

    public SortCodeSubstitutionCheck(SortCodeSubstitution sortCodeSubstitution, AtLeastOneWeightRowGate next) {
        this.sortCodeSubstitution = sortCodeSubstitution;
        this.next = next;
    }

    @Override
    public ModulusResult check(ModulusCheckParams params) {
        return next.check(new ModulusCheckParams(
                    sortCodeSubstitution.Apply(params.account),
                    params.firstWeightRow, params.secondWeightRow));
    }
}
