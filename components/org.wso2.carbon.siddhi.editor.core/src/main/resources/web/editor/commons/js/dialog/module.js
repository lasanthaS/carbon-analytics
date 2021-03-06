/**
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org)  Apache License, Version 2.0  http://www.apache.org/licenses/LICENSE-2.0
 */
define(['./save-to-file-dialog', './replace-confirm-dialog', './open-file-dialog','./extension-install-dialog', './error-handler-dialog', './close-confirm-dialog',
        './import-file-dialog', './export-file-dialog', './settings-dialog', './close-all-confirm-dialog',
        './delete-confirm-dialog', './open-sample-file-dialog', './export-dialog', './sample-event-dialog',
        './query-store-dialog', './deploy-file-dialog', './export-dialog', './generate-stream-dialog', './confirm-switch-to-code-dialog'],
    function (SaveToFileDialog, ReplaceConfirmDialog, OpenFileDialog, ExtensionInstallDialog, ErrorHandlerDialog, CloseConfirmDialog, ImportFileDialog,
              ExportFileDialog, SettingsDialog, CloseAllConfirmDialog, DeleteConfirmDialog, OpenSampleFileDialog,
              DockerExportDialog, SampleEventDialog, QueryStoreDialog, DeployFileDialog, ExportDialog,
              GenerateStreamDialog, ConfirmSwitchToCode) {
        return {
            save_to_file_dialog: SaveToFileDialog,
            open_file_dialog: OpenFileDialog,
            CloseConfirmDialog: CloseConfirmDialog,
            ReplaceConfirmDialog: ReplaceConfirmDialog,
            ExtensionInstallDialog :ExtensionInstallDialog,
            error_handler_dialog: ErrorHandlerDialog,
            import_file_dialog: ImportFileDialog,
            export_file_dialog: ExportFileDialog,
            settings_dialog: SettingsDialog,
            CloseAllConfirmDialog: CloseAllConfirmDialog,
            DeleteConfirmDialog: DeleteConfirmDialog,
            open_sample_file_dialog: OpenSampleFileDialog,
            sample_event_dialog: SampleEventDialog,
            query_store_api: QueryStoreDialog,
            deploy_file_dialog: DeployFileDialog,
            export_dialog: ExportDialog,
            generate_stream_dialog: GenerateStreamDialog,
            confirm_switch_to_code: ConfirmSwitchToCode
        };
    });
