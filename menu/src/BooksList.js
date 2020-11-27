import * as React from "react";
import { cloneElement, useMemo } from 'react';
import { List, Datagrid, TextField, NumberField, useListContext, ExportButton, CreateButton, TopToolbar, sanitizeListRestProps, BooleanField} from 'react-admin';
import {Grid, Button} from '@material-ui/core'
import PropTypes from 'prop-types';

const ListActions = (props) => {
    const {
        className,
        exporter,
        filters,
        maxResults,
        ...rest
    } = props;
    const {
        currentSort,
        resource,
        displayedFilters,
        filterValues,
        hasCreate,
        basePath,
        selectedIds,
        showFilter,
        total,
    } = useListContext();
    return (
        <TopToolbar className={className} {...sanitizeListRestProps(rest)}>
            {filters && cloneElement(filters, {
                resource,
                showFilter,
                displayedFilters,
                filterValues,
                context: 'button',
            })}
            <ExportButton
                disabled={total === 0}
                resource={resource}
                sort={currentSort}
                filterValues={filterValues}
                maxResults={maxResults}
            />
            <Button
                /*Tutaj dodamy kod do dodawania do wish listy*/
                onClick={() => { alert('Your custom action'); }}>
                Add to wish list
            </Button>
        </TopToolbar>
    );
};

export const PostList = (props) => (
    <List {...props} actions={<ListActions />}>
        <Datagrid>
            <NumberField source="id" />
            <TextField source="title" />
            <TextField source="author" />
            <TextField source="description" />
            <BooleanField source="avalible" />
        </Datagrid>
    </List>
);

export default PostList