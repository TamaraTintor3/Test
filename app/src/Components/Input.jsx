import { TextField } from '@material-ui/core';
import PropTypes from 'prop-types';
import React from 'react';

const Input = (props) => {
  return (
    <TextField
      min={props.min}
      variant='outlined'
      style={{ width: '100%' }}
      size='small'
      placeholder={props.placeholder}
      inputProps={{
        maxLength: props.maxLength,
        min: '1',
        step: '1',
      }}
      {...props}
      fullWidth={props.fullWidth}
      onChange={(event) => {
        console.log(' input id', event.target.id);
        console.log(' input value ', event.target.value);
        props.onChange({
          id: event.target.id,
          value: event.target.value,
        });
      }}
      onKeyPress={props.onKeyPress}
    />
  );
};

export default Input;

Input.propTypes = {
  id: PropTypes.string.isRequired,
  label: PropTypes.string.isRequired,
  value: PropTypes.string.isRequired,
  onChange: PropTypes.func.isRequired,
};
