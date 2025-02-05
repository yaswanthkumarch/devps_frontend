import { render, screen } from '@testing-library/react';
import App from './App';  // Adjust the import path if needed

test('renders timesheet management system header', () => {
  render(<App />);
  const headerElement = screen.getByText(/Welcome to the Timesheet Management System/i);
  expect(headerElement).toBeInTheDocument();
});

