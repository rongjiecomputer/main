package seedu.planner.model.util;

import java.util.List;

import com.google.common.collect.ImmutableMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.planner.model.module.Module;
import seedu.planner.model.module.ModuleInfo;
import seedu.planner.model.module.ModuleType;

/**
 * Represents a temporary class to generator sample {@code Module}s.
 */
public class SampleModulesUtil {

    // @@author rongjiecomputer
    /**
     * Returns a specified number of {@code ObservableList}s.
     *
     * @param count Number of modules to be returned in the {@code ObservableList}
     * @return An {@code ObservableList} with the specified number of modules in {@code count}
     */
    public static ObservableList<Module> genModules(int count) {
        ModuleType[] pt1 = new ModuleType[]{ModuleType.PR_FOUNDATION, ModuleType.UNRESTRICTED_ELECTIVES};
        ModuleType[] pt2 = new ModuleType[]{ModuleType.PR_BREADTH_AND_DEPTH, ModuleType.UNRESTRICTED_ELECTIVES};
        ModuleType[] pt3 = new ModuleType[]{ModuleType.PR_IT_PROFESSIONALISM, ModuleType.UNRESTRICTED_ELECTIVES};

        ModuleInfo cs1010 = new ModuleInfo("CS1010", "Programming Methodology I", pt1,
                4, new String[]{}, new String[]{});

        ModuleInfo cs1231 = new ModuleInfo("CS1231", "Discrete structure", pt2,
                4, new String[]{}, new String[]{});

        ModuleInfo cs2030 = new ModuleInfo("CS2030", "Programming Methodology II", pt3,
                4, new String[]{}, new String[]{"CS1010"});

        ModuleInfo cs2040 = new ModuleInfo("CS2040", "Data Structure", pt1,
                4, new String[]{"CS2040C"}, new String[]{"CS1010", "CS1231"});

        ModuleInfo cs2040c = new ModuleInfo("CS2040C", "Data Structure", pt1,
                4, new String[]{"CS2040"}, new String[]{"CS1010", "CS1231"});

        ImmutableMap.Builder<String, ModuleInfo> builder = ImmutableMap.builder();
        builder.put("CS1010", cs1010);
        builder.put("CS1231", cs1231);
        builder.put("CS2030", cs2030);
        builder.put("CS2040", cs2040);
        builder.put("CS2040C", cs2040c);

        ImmutableMap<String, ModuleInfo> map = builder.build();
        cs1010.finalize(map);
        cs1231.finalize(map);
        cs2030.finalize(map);
        cs2040.finalize(map);
        cs2040c.finalize(map);

        Module m1 = new Module(ModuleType.PR_FOUNDATION, cs1010);
        Module m2 = new Module(ModuleType.PR_BREADTH_AND_DEPTH, cs1231);
        Module m3 = new Module(ModuleType.PR_IT_PROFESSIONALISM, cs2030);
        Module m4 = new Module(ModuleType.PR_FOUNDATION, cs2040);
        Module m5 = new Module(ModuleType.PR_FOUNDATION, cs2040c);

        List<Module> modules = List.of(m1, m2, m3, m4, m5);

        return FXCollections.observableList(modules.subList(0, count));
    }
}
