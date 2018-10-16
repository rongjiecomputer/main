package seedu.planner.storage;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.google.common.collect.ImmutableMap;

import seedu.planner.commons.exceptions.DataConversionException;
import seedu.planner.commons.util.JsonUtil;
import seedu.planner.model.module.ModuleInfo;
import seedu.planner.model.module.ModuleType;

//@@author rongjiecomputer
/**
 * A class to access {@link seedu.planner.model.module.ModuleInfo} stored in the hard disk as a json file.
 */
public class JsonModuleInfoStorage implements ModuleInfoStorage {

    private Path filePath;

    public JsonModuleInfoStorage(Path filePath) {
        this.filePath = filePath;
    }


    public Path getModuleInfoFilePath() {
        return filePath;
    }

    @Override
    public Optional<ModuleInfo[]> readModuleInfo() throws DataConversionException {
        Optional<ModuleInfo[]> optionalModuleInfo = JsonUtil.readJsonFile(filePath, ModuleInfo[].class);
        return optionalModuleInfo.map(this::finalizeModuleInfo);
    }

    private ModuleInfo[] finalizeModuleInfo(ModuleInfo[] moduleInfo) {
        ImmutableMap.Builder<String, ModuleInfo> builder = ImmutableMap.builder();
        for (ModuleInfo mInfo : moduleInfo) {
            builder.put(mInfo.getCode(), mInfo);
        }

        // TODO(rongjiecomputer) This code->moduleInfo map is useful for other class too.
        // Figure out a place to expose this to other classes.
        ImmutableMap<String, ModuleInfo> map = builder.build();

        for (ModuleInfo mInfo : moduleInfo) {
            mInfo.finalize(map);
        }
        return moduleInfo;
    }

    /**
     * Returns {@code ModuleInfo} of a certain {@code ModuleType} that {@code ModuleInfoStorage} stores.
     *
     * @param moduleType Type of {@code module}
     * @return A list of {@code ModuleInfo} of {@code moduleType}
     */
    @Override
    public List<ModuleInfo> getModuleInfo(ModuleType moduleType) {
        // TODO(rongjiecomputer) Implement filter
        return new ArrayList<>();
    }
}
