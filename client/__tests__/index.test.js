import React from 'react';
import { render } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect';
import Home from '../pages/index';
it('renders Home Component', () => {
    const {getByText} = render(<Home />);
    expect(getByText('HOME')).toBeInTheDocument();
});
